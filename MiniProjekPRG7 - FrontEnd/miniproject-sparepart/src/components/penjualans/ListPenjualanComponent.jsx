// ListPenjualanComponent.js
import React, { useEffect, useState } from 'react';
import { listPenjualans } from '../../service/TransaksiPenjualanService';

function ListPenjualanComponent() {
    const [penjualans, setPenjualans] = useState([]);
    const [searchTerm, setSearchTerm] = useState('');

    useEffect(() => {
        listPenjualans()
            .then(dates => {
                setPenjualans(dates);
            })
            .catch(error => {
                console.error(error);
            });
    }, []);

    const filteredPenjualans = penjualans.filter(penjualan =>
        penjualan.toLowerCase().includes(searchTerm.toLowerCase())
    );

    return (
        <div className="container-fluid">
            <h1 className="h3 mb-2 text-gray-800">Riwayat Transaksi</h1>
            <div className="card shadow mb-4">
                <div className="card-header py-3">
                    <h6 className="m-0 font-weight-bold text-primary">Riwayat Transaksi SPAREPART</h6>
                </div>
                <div className="card-body">
                    <div className="mb-3">
                        <input
                            type="text"
                            className="form-control"
                            placeholder="Cari berdasarkan tanggal..."
                            value={searchTerm}
                            onChange={(e) => {
                                setSearchTerm(e.target.value);
                            }}
                        />
                    </div>
                    <div className="table-responsive">
    <table className="table table-bordered" id="" width="100%" cellSpacing="0">
        <thead>
            <tr>
                <th>No</th>
                <th>Tanggal</th>
                <th>Total</th>
            </tr>
        </thead>
        <tbody>
            {[  
                { tanggal: '2024-04-22', total: 80000 },
                { tanggal: '2024-04-22', total: 1646000 },
                { tanggal: '2024-04-22', total: 80000 },
                { tanggal: '2024-04-23', total: 830000 },
            ].map((data, index) => (
                <tr key={index}>
                    <td>{index + 1}</td>
                    <td>{data.tanggal}</td>
                    <td>{data.total}</td>
                </tr>
            ))}
        </tbody>
    </table>
</div>

                </div>
            </div>
        </div>
    );
}

export default ListPenjualanComponent;
