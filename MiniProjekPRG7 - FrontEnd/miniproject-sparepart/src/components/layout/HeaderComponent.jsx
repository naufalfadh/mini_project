import React, { useState } from 'react';
import { Link } from 'react-router-dom';
import { FaCar } from 'react-icons/fa';
import Modal from 'react-modal';

const HeaderComponent = () => {
    const [modalIsOpen, setModalIsOpen] = useState(false);

    const openModal = () => {
        setModalIsOpen(true);
    }

    const closeModal = () => {
        setModalIsOpen(false);
    }

    return (
        <>
            <header className="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">
                {/* Sidebar Toggle (Topbar) */}
                <button id="sidebarToggleTop" className="btn btn-link d-md-none rounded-circle mr-3">
                    <i className="fa fa-bars"></i>
                </button>

                <Link className='sidebar-brand d-flex align-items-center justify-content-center' to='/'>
    <div className='sidebar-brand-icon rotate-n-15'>
        <i className='fa-solid fa-car'></i>
    </div>
    <div className='sidebar-brand-text mx-3' style={{ fontSize: '1.5em', fontWeight: 'bold' }}>Kelompok Jidan</div>
</Link>

{/* Master Menu */}
<ul className="navbar-nav mr-auto">
    <li className="nav-item dropdown">
        <a className="nav-link dropdown-toggle" href="#" id="masterDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" style={{ fontWeight: 'bold' }}>
            Master
        </a>
        <div className="dropdown-menu" aria-labelledby="masterDropdown">
            <Link className="dropdown-item" to="/spareparts">Sparepart</Link>
        </div>
    </li>
    <li className="nav-item">
        <Link className="nav-link" to="/transaksi">
            Transaksi
        </Link>
    </li>
    <li className="nav-item">
        <Link className="nav-link" to="/riwayat-penjualan">
            Riwayat Penjualan
        </Link>
    </li>
</ul>

                

                {/* Topbar Navbar */}
                <ul className="navbar-nav ml-auto">
                    <button className="btn btn-outline-dark" type="button" onClick={openModal}>
                        <FaCar className="me-1" />
                        Welcome
                    </button>
                </ul>
            </header>

            <Modal
                isOpen={modalIsOpen}
                onRequestClose={closeModal}
                contentLabel="Video Modal"
            >
                <div>
                    <button onClick={closeModal}>Close Modal</button>
                    <iframe
                        width="1100"
                        height="600"
                        src="https://www.youtube.com/embed/FZspvWCOtCc?si=HecXcPByi2FZ7U2S"
                        title="YouTube video player"
                        frameBorder="0"
                        allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
                        referrerPolicy="strict-origin-when-cross-origin"
                        allowFullScreen
                    ></iframe>
                </div>
            </Modal>
        </>
    );
}

export default HeaderComponent;
