import React, { useState, useEffect } from 'react';
import { listSpareparts,updateSparepart } from '../../service/SparepartService';
import { listPenjualans, savePenjualan, getPenjualanById } from '../../service/TransaksiPenjualanService';
import Form from 'react-bootstrap/Form';
import Table from 'react-bootstrap/Table';
import Button from 'react-bootstrap/Button';
import swal from 'sweetalert';

function TransaksiPenjualan() {
    const [spareparts, setSpareparts] = useState([]);
    const [searchTerm, setSearchTerm] = useState('');
    const [selectedItems, setSelectedItems] = useState([]);
    const [quantityMap, setQuantityMap] = useState({});
    const [totalPrice, setTotalPrice] = useState(0);
    const [cartQuantityMap, setCartQuantityMap] = useState({});
    const [change, setChange] = useState(0);
    const [payment, setPayment] = useState('');

    useEffect(() => {
        listSpareparts()
            .then(response => {
                setSpareparts(response.data.data);
            })
            .catch(error => {
                console.error(error);
            });
    }, []);

    useEffect(() => {
        updateTotalPrice();
    }, [selectedItems]);

    const addItemToCart = (item) => {
        const itemId = item.id;
        const newQuantity = (cartQuantityMap[itemId] || 0) + (quantityMap[itemId] || 1);
        const updatedCart = { ...cartQuantityMap, [itemId]: newQuantity };
        setCartQuantityMap(updatedCart);
        const existingItemIndex = selectedItems.findIndex(selectedItem => selectedItem.id === itemId);
        if (existingItemIndex !== -1) {
            const updatedItems = [...selectedItems];
            updatedItems[existingItemIndex].quantity = newQuantity;
            setSelectedItems(updatedItems);
        } else {
            const newItem = { ...item, quantity: newQuantity };
            setSelectedItems([...selectedItems, newItem]);
        }
        updateTotalPrice();
        swal("Item ditambahkan ke keranjang.", { icon: "success" });
    };

    const handleQuantityChange = (itemId, value) => {
        const newQuantity = parseInt(value);
        if (isNaN(newQuantity) || newQuantity < 1) return;
        setQuantityMap({ ...quantityMap, [itemId]: newQuantity });
        updateTotalPrice();
    };

    const handleItemQuantityChange = (itemId, changeAmount) => {
        const newQuantity = (cartQuantityMap[itemId] || 0) + changeAmount;
        if (newQuantity < 1) return;
        
        const updatedCart = { ...cartQuantityMap, [itemId]: newQuantity };
        setCartQuantityMap(updatedCart);
        
 
        const updatedItems = selectedItems.map(item => {
            if (item.id === itemId) {
                return { ...item, quantity: newQuantity };
            }
            return item;
        });
        setSelectedItems(updatedItems);
    
        updateTotalPrice();
    };
    

    const updateTotalPrice = () => {
        let total = 0;
        selectedItems.forEach(item => {
            total += item.harga * (cartQuantityMap[item.id] || 0);
        });
        setTotalPrice(total);
    };

    useEffect(() => {
        calculateChange();
    }, [payment, totalPrice]);

    const removeItemFromCart = (itemId) => {
        const updatedCart = { ...cartQuantityMap };
        delete updatedCart[itemId];
        setCartQuantityMap(updatedCart);
        const updatedItems = selectedItems.filter(item => item.id !== itemId);
        setSelectedItems(updatedItems);
        updateTotalPrice();
        swal("Item dihapus dari keranjang.", { icon: "success" });
    };

    const calculateChange = () => {
        const paymentAmount = parseFloat(payment);
        if (isNaN(paymentAmount)) return; 
        const changeAmount = paymentAmount - totalPrice;
        setChange(changeAmount >= 0 ? changeAmount : 0);
    };

 

    const saveTransaction = () => {
        const today = new Date().toISOString().split('T')[0]; 
        const transaksiPenjualan = {
            tanggal: today,
            total: totalPrice,
            kryId: 3, 
            detailPenjualanList: selectedItems.map(item => ({ sparepartId: item.id, jumlah: item.quantity }))
        };
    
        if (!payment || parseFloat(payment) < totalPrice) {
            swal("Jumlah pembayaran kurang atau tidak dimasukkan.", { icon: "error" });
            return; 
        }
    
        // Memeriksa apakah ada item yang dipilih untuk transaksi
        if (selectedItems.length === 0) {
            swal("Tidak ada item yang dipilih untuk transaksi.", { icon: "error" });
            return; 
        }
    
        // Jika data sudah lengkap, lanjutkan proses menyimpan transaksi
        savePenjualan(transaksiPenjualan)
            .then(response => {
                swal("Transaksi berhasil disimpan.", { icon: "success" });
    
                Promise.all(selectedItems.map(item => {
                    const updatedStock = item.stok - (cartQuantityMap[item.id] || 0);
    
                    return updateSparepart({ ...item, stok: updatedStock }, item.id);
                }))
                .then(() => {
                    console.log("Stok item berhasil diperbarui.");
    
                    listSpareparts()
                        .then(response => {
                            setSpareparts(response.data.data);
                        })
                        .catch(error => {
                            console.error(error);
                        });
    
                    setSelectedItems([]);
                    setCartQuantityMap({});
                    setPayment('');
                    setChange(0);
                })
                .catch(error => {
                    console.error("Gagal memperbarui stok item.", error);
                    swal("Terjadi kesalahan saat menyimpan transaksi.", { icon: "error" });
                });
            })
            .catch(error => {
                console.error(error);
                swal("Terjadi kesalahan saat menyimpan transaksi.", { icon: "error" });
            });
    };
     
    return (
        <div className="container-fluid">
            <h1 className="h3 mb-2 text-gray-800">Transaksi Penjualan</h1>
            <div className="card shadow mb-4">
                <div className="card-header py-3">
                    <h6 className="m-0 font-weight-bold text-primary">Cari dan Tambahkan Item ke Keranjang</h6>
                </div>
                <div className="card-body">
                    <Form.Group className="mb-3" controlId="search">
                        <Form.Control
                            type="text"
                            placeholder="Cari item..."
                            value={searchTerm}
                            onChange={(e) => setSearchTerm(e.target.value)}
                        />
                    </Form.Group>
                    <Table striped bordered hover>
                        <thead>
                            <tr>
                                <th>Nama</th>
                                <th>Harga</th>
                                <th>Stok</th>
                                <th>Brand</th>
                                <th>Aksi</th>
                            </tr>
                        </thead>
                        <tbody>
                        {spareparts.filter(item => item.nama.toLowerCase().includes(searchTerm.toLowerCase()) && item.status === 1).map(item => (
                                <tr key={item.id}>
                                    <td>{item.nama}</td>
                                    <td>Rp {item.harga.toLocaleString('id-ID')},00</td>
                                    <td>{item.stok}</td>
                                    <td>{item.sup}</td>
                                  
                                    <td>
                                        <Button variant="primary" onClick={() => addItemToCart(item)}>Tambah ke Keranjang</Button>
                                    </td>
                                </tr>
                            ))}
                        </tbody>
                    </Table>
                </div>
            </div>

            <div className="card shadow mb-4">
                <div className="card-header py-3">
                    <h6 className="m-0 font-weight-bold text-primary">Keranjang</h6>
                </div>
                <div className="card-body">
                    <Table striped bordered hover>
                        <thead>
                            <tr>
                                <th>Nama</th>
                                <th>Harga</th>
                                <th>Stok</th>
                                <th>Brand</th>
                                <th>Jumlah</th>
                                <th>Total Harga</th>
                                <th>Aksi</th>
                            </tr>
                        </thead>
                        <tbody>
                            {selectedItems.map(item => (
                                <tr key={item.id}>
                                    <td>{item.nama}</td>
                                    <td>Rp {item.harga.toLocaleString('id-ID')},00</td>
                                    <td>{item.stok}</td>
                                    <td>{item.sup}</td>
                                    <td>
                                        <Button variant="outline-primary" size="sm" onClick={() => handleItemQuantityChange(item.id, -1)}>-</Button>
                                        <span className="mx-2">{cartQuantityMap[item.id]}</span>
                                        <Button variant="outline-primary" size="sm" onClick={() => handleItemQuantityChange(item.id, 1)}>+</Button>
                                    </td>
                                    <td>Rp {(item.harga * (cartQuantityMap[item.id] || 0)).toLocaleString('id-ID')},00</td>
                                    <td>
                                        <Button variant="danger" onClick={() => removeItemFromCart(item.id)}>Hapus</Button>
                                    </td>
                                </tr>
                            ))}
                            <tr>
                                <td colSpan="5">Total</td>
                                <td colSpan="2">Rp {totalPrice.toLocaleString('id-ID')},00</td>
                            </tr>
                            <tr>
                                <td colSpan="5">Jumlah Pembayaran</td>
                                <td colSpan="2">
                                    <Form.Control
                                        type="number"
                                        min="0"
                                        value={payment}
                                        onChange={(e) => setPayment(e.target.value)}
                                    />
                                </td>
                            </tr>
                            <tr>
                                <td colSpan="5">Kembalian</td>
                                <td colSpan="2">Rp {change.toLocaleString('id-ID')},00</td>
                            </tr>
                            <tr>
                                <td colSpan="7">
                                    <Button variant="success" onClick={saveTransaction}>Simpan Transaksi</Button>
                                </td>
                            </tr>
                        </tbody>
                    </Table>
                </div>
            </div>
        </div>
    );
}

export default TransaksiPenjualan;
