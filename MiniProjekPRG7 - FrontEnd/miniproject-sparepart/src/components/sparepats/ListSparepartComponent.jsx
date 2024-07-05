import React, { useEffect, useState } from 'react';
import { listSpareparts, saveSparepart, updateSparepart, getSparepartById, deleteSparepart } from '../../service/SparepartService';
import { useNavigate } from 'react-router-dom';
import Form from 'react-bootstrap/Form';
import Modal from 'react-bootstrap/Modal';
import Button from 'react-bootstrap/Button';
import swal from 'sweetalert';

function ListSparepartComponent() {
    const [spareparts, setSpareparts] = useState([]);
    const [showAddModal, setShowAddModal] = useState(false);
    const [sparepartDataAdd, setSparepartDataAdd] = useState({
        nama: '',
        harga: '',
        stok: '',
        sup: ''
    });
    const [showUpdateModal, setShowUpdateModal] = useState(false);
    const [sparepartDataUpdate, setSparepartDataUpdate] = useState({
        id: null,
        nama: '',
        harga: '',
        stok: '',
        sup: ''
    });
    const [selectedImage, setSelectedImage] = useState(null);

    const navigator = useNavigate();

    useEffect(() => {
        listSpareparts()
            .then(response => {
                setSpareparts(response.data.data);
            })
            .catch(error => {
                console.error(error);
            });
    }, []);

    const handleShowAddModal = () => setShowAddModal(true);

    const handleCloseAddModal = () => {
        setShowAddModal(false);
        setSparepartDataAdd({
            nama: '',
            harga: '',
            stok: '',
            sup: ''
        });
    };

    const handleAddSparepart = () => {
        // Memeriksa apakah semua field sudah diisi
        if (!sparepartDataAdd.nama || !sparepartDataAdd.harga || !sparepartDataAdd.stok || !sparepartDataAdd.sup || !selectedImage) {
            swal("Semua kolom harus diisi.", {
                icon: "warning",
            });
            return; // Menghentikan proses jika ada field yang kosong
        }

        const formData = new FormData();
        formData.append('nama', sparepartDataAdd.nama);
        formData.append('harga', sparepartDataAdd.harga);
        formData.append('stok', sparepartDataAdd.stok);
        formData.append('sup', sparepartDataAdd.sup);
        formData.append('gambar', selectedImage);

        // Jika semua field sudah diisi, lanjutkan proses menyimpan data
        saveSparepart(formData)
            .then(() => {
                handleCloseAddModal();
                listSpareparts()
                    .then(response => {
                        setSpareparts(response.data.data);
                    })
                    .catch(error => {
                        console.error(error);
                    });
                swal("Data SPAREPART berhasil disimpan.", {
                    icon: "success",
                });
            })
            .catch(error => {
                console.error(error);
                swal("Gagal menyimpan data SPAREPART.", {
                    icon: "error",
                });
            });
    };

    const handleInputAddChange = (e) => {
        const { name, value } = e.target;
        setSparepartDataAdd({
            ...sparepartDataAdd,
            [name]: parseInt(value) || value,
        });
    };

    const handleShowUpdateModal = (sparepartId) => {
        const sparepartToUpdate = spareparts.find(sparepart => sparepart.id === sparepartId);
        setSparepartDataUpdate({
            id: sparepartToUpdate.id,
            nama: sparepartToUpdate.nama,
            harga: sparepartToUpdate.harga,
            stok: sparepartToUpdate.stok,
            sup: sparepartToUpdate.sup
        });
        setShowUpdateModal(true);
    };

    const handleCloseUpdateModal = () => {
        setShowUpdateModal(false);
        setSparepartDataUpdate({
            id: null,
            nama: '',
            harga: '',
            stok: '',
            sup: ''
        });
    };

    const handleUpdateSparepart = () => {
        const formData = new FormData();
        formData.append('nama', sparepartDataUpdate.nama);
        formData.append('harga', sparepartDataUpdate.harga);
        formData.append('stok', sparepartDataUpdate.stok);
        formData.append('sup', sparepartDataUpdate.sup);
        formData.append('gambar', selectedImage);

        updateSparepart(formData, sparepartDataUpdate.id)
            .then(() => {
                handleCloseUpdateModal();
                listSpareparts()
                    .then(response => {
                        setSpareparts(response.data.data);
                    })
                    .catch(error => {
                        console.error(error);
                    });
                swal("Data SPAREPART berhasil diperbarui.", {
                    icon: "success",
                });
            })
            .catch(error => {
                console.error(error);
                swal("Gagal memperbarui data SPAREPART.", {
                    icon: "error",
                });
            });
    };

    const confirmDelete = (sparepartId) => {
        swal({
            title: "Apakah Anda yakin?",
            text: "Anda akan menghapus data SPAREPART ini.",
            icon: "warning",
            buttons: ["Batal", "Hapus"],
            dangerMode: true,
        })
            .then((willDelete) => {
                if (willDelete) {
                    deleteSparepart(sparepartId)
                        .then(() => {
                            listSpareparts()
                                .then((response) => {
                                    setSpareparts(response.data.data);
                                })
                                .catch((error) => {
                                    console.error(error);
                                });
                            swal("Data SPAREPART berhasil dihapus.", {
                                icon: "success",
                            });
                        })
                        .catch((error) => {
                            console.error(error);
                            swal("Gagal menghapus data SPAREPART.", {
                                icon: "error",
                            });
                        });
                } else {
                    swal("Penghapusan dibatalkan.");
                }
            });
    };

    return (
        <>
            <div className="container-fluid">
                <h1 className="h3 mb-2 text-gray-800">Sparepart</h1>
                <button className='btn btn-primary m-2' onClick={handleShowAddModal}>Tambah Sparepart</button>
                <div className="card shadow mb-4">
                    <div className="card-header py-3">
                        <h6 className="m-0 font-weight-bold text-primary">Data SPAREPART</h6>
                    </div>
                    <div className="card-body">
                        <div className="table-responsive">
                            <table className="table table-bordered" id="" width="100%" cellSpacing="0">
                                <thead>
                                    <tr>
                                        <th>Nama</th>
                                        <th>Harga</th>
                                        <th>Stok</th>
                                        <th>Brand</th>
                                        <th>Status</th>
                                        <th>Aksi</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    {spareparts.map(sparepart => (
                                        <tr key={sparepart.id}>
                                            <td>{sparepart.nama}</td>
                                            <td>Rp {sparepart.harga.toLocaleString('id-ID')},00</td>
                                            <td>{sparepart.stok}</td>
                                            <td>{sparepart.sup}</td>
                                            <td>{sparepart.status === 1 ? 'Aktif' : 'Tidak Aktif'}</td>
                                            <td>
                                                <button className="btn btn-info mr-2" onClick={() => handleShowUpdateModal(sparepart.id)}>Ubah</button>
                                                <button className="btn btn-danger" onClick={() => confirmDelete(sparepart.id)}>Hapus</button>
                                            </td>
                                        </tr>
                                    ))}
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>

            <Modal show={showAddModal} onHide={handleCloseAddModal}>
                <Modal.Header>
                    <Modal.Title>Tambah SPAREPART</Modal.Title>
                </Modal.Header>
                <Modal.Body>
                    <Form>
                        <Form.Group className="mb-3" controlId="nama">
                            <Form.Label>Nama SPAREPART</Form.Label>
                            <Form.Control
                                type="text"
                                name="nama"
                                value={sparepartDataAdd.nama}
                                onChange={handleInputAddChange}
                                autoFocus
                            />
                        </Form.Group>
                        <Form.Group className="mb-3" controlId="harga">
                            <Form.Label>Harga</Form.Label>
                            <Form.Control
                                type="number"
                                name="harga"
                                value={sparepartDataAdd.harga}
                                onChange={handleInputAddChange}
                            />
                        </Form.Group>
                        <Form.Group className="mb-3" controlId="stok">
                            <Form.Label>Stok</Form.Label>
                            <Form.Control
                                type="number"
                                name="stok"
                                value={sparepartDataAdd.stok}
                                onChange={handleInputAddChange}
                            />
                        </Form.Group>
                        <Form.Group className="mb-3" controlId="sup">
                            <Form.Label>Brand</Form.Label>
                            <Form.Control
                                type="text"
                                name="sup"
                                value={sparepartDataAdd.sup}
                                onChange={handleInputAddChange}
                            />
                        </Form.Group>
                        <Form.Group className="mb-3" controlId="gambar">
                            <Form.Label>Gambar</Form.Label>
                            <Form.Control
                                type="file"
                                onChange={(e) => setSelectedImage(e.target.files[0])}
                            />
                        </Form.Group>
                    </Form>
                </Modal.Body>
                <Modal.Footer>
                    <Button variant="secondary" onClick={handleCloseAddModal}>Tutup</Button>
                    <Button variant="primary" onClick={handleAddSparepart}>Simpan</Button>
                </Modal.Footer>
            </Modal>

            <Modal show={showUpdateModal} onHide={handleCloseUpdateModal}>
                <Modal.Header>
                    <Modal.Title>Ubah SPAREPART</Modal.Title>
                </Modal.Header>
                <Modal.Body>
                    <Form>
                        <Form.Group className="mb-3" controlId="nama">
                            <Form.Label>Nama SPAREPART</Form.Label>
                            <Form.Control
                                type="text"
                                name="nama"
                                value={sparepartDataUpdate.nama}
                                onChange={(e) => setSparepartDataUpdate({ ...sparepartDataUpdate, nama: e.target.value })}
                                autoFocus
                            />
                        </Form.Group>
                        <Form.Group className="mb-3" controlId="harga">
                            <Form.Label>Harga</Form.Label>
                            <Form.Control
                                type="number"
                                name="harga"
                                value={sparepartDataUpdate.harga}
                                onChange={(e) => setSparepartDataUpdate({ ...sparepartDataUpdate, harga: e.target.value })}
                            />
                        </Form.Group>
                        <Form.Group className="mb-3" controlId="stok">
                            <Form.Label>Stok</Form.Label>
                            <Form.Control
                                type="number"
                                name="stok"
                                value={sparepartDataUpdate.stok}
                                onChange={(e) => setSparepartDataUpdate({ ...sparepartDataUpdate, stok: e.target.value })}
                            />
                        </Form.Group>
                        <Form.Group className="mb-3" controlId="sup">
                            <Form.Label>Brand</Form.Label>
                            <Form.Control
                                type="text"
                                name="sup"
                                value={sparepartDataUpdate.sup}
                                onChange={(e) => setSparepartDataUpdate({ ...sparepartDataUpdate, sup: e.target.value })}
                            />
                        </Form.Group>
                        <Form.Group className="mb-3" controlId="gambar">
                            <Form.Label>Gambar</Form.Label>
                            <Form.Control
                                type="file"
                                onChange={(e) => setSelectedImage(e.target.files[0])}
                            />
                        </Form.Group>
                    </Form>
                </Modal.Body>
                <Modal.Footer>
                    <Button variant="secondary" onClick={handleCloseUpdateModal}>Tutup</Button>
                    <Button variant="primary" onClick={handleUpdateSparepart}>Simpan Perubahan</Button>
                </Modal.Footer>
            </Modal>
        </>
    );
}

export default ListSparepartComponent;
