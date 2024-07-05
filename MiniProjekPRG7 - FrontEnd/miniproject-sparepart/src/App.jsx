import { useState } from 'react';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import HeaderComponent from './components/layout/HeaderComponent';
import FooterComponent from './components/layout/FooterComponent';
import ListSparepartComponent from './components/sparepats/ListSparepartComponent';
import ListPenjualanComponenet from './components/penjualans/ListPenjualanComponent'; 
import ChartComponent from './components/layout/ChartComponent';
import './App.css';
import TransaksiPenjualan from './components/penjualans/TransaksiPenjualan';

function App() {
  const [count, setCount] = useState(0);

  return (
    <>
    <BrowserRouter>
      <div id='wrapper'>
        <div id='content-wrapper' className='d-flex flex-column'>
          <div id='content'>
            <HeaderComponent />
            <Routes>
            <Route path='/' element={ <ChartComponent />}></Route>
               <Route path='/spareparts' element={ <ListSparepartComponent />}></Route>
               <Route path='/riwayat-penjualan' element={ <ListPenjualanComponenet />}></Route>
               <Route path='/transaksi' element={ <TransaksiPenjualan />}></Route>
            </Routes>
          </div>
          <FooterComponent />
        </div>
      </div>
    </BrowserRouter>
    </>
  );
}

export default App;
