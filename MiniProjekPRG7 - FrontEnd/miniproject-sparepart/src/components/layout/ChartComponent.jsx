import React, { useState, useEffect } from 'react';
import Chart from 'chart.js/auto';

const ChartComponent = () => {
    const [monthlyIncomeData, setMonthlyIncomeData] = useState([]);
    const [selectedYear, setSelectedYear] = useState(new Date().getFullYear());

    // Initializing with static data for demonstration
    useEffect(() => {
        const staticData = [
            { month: 1, income: 0 },
            { month: 2, income: 0 },
            { month: 3, income: 0 },
            { month: 4, income: 2636000 },
            { month: 5, income: 0 },
            { month: 6, income: 0 },
            { month: 7, income: 0 },
            { month: 8, income: 0 },
            { month: 9, income: 0 },
            { month: 10, income: 0 },
            { month: 11, income: 0 },
            { month: 12, income: 0 },
        ];

        const transformedData = staticData.map(item => ({
            month: getMonthName(item.month),
            income: item.income
        }));

        setMonthlyIncomeData(transformedData);
    }, []);

    // Chart setup
    useEffect(() => {
        const ctx = document.getElementById('myAreaChart');
        const chartInstance = new Chart(ctx, {
            type: 'bar', // Main type as bar
            data: {
                labels: monthlyIncomeData.map(data => data.month),
                datasets: [{
                    type: 'line', // Override the type for this dataset to line
                    label: `Pendapatan Tahun 2024 (Line)`,
                    data: monthlyIncomeData.map(data => data.income),
                    borderColor: "rgba(78, 115, 223, 1)",
                    borderWidth: 2,
                    fill: false,
                }, {
                    type: 'bar', // Explicitly specifying, even though it's the default from the main type
                    label: `Pendapatan Tahun 2024 (Bar)`,
                    data: monthlyIncomeData.map(data => data.income),
                    backgroundColor: "rgba(78, 115, 223, 0.5)",
                    borderColor: "rgba(78, 115, 223, 1)",
                    borderWidth: 1,
                }]
            },
            options: {
                responsive: true,
                plugins: {
                    tooltip: {
                        callbacks: {
                            label: function(context) {
                                return `${context.dataset.label}: ${new Intl.NumberFormat('id-ID', { style: 'currency', currency: 'IDR' }).format(context.parsed.y)}`;
                            }
                        }
                    }
                }
            }
        });

        return () => chartInstance.destroy();
    }, [monthlyIncomeData, selectedYear]);

    const getMonthName = (monthNumber) => {
        const months = ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"];
        return months[monthNumber - 1];
    };

    return (
        <div className="container-fluid">
            <div className="row">
                <div className="col-xl-8 col-lg-8">
                    <div className="card shadow mb-4">
                        <div className="card-header py-3 d-flex justify-content-between align-items-center">
                            <h6 className="m-0 font-weight-bold text-primary">Grafik Pendapatan</h6>
                        </div>
                        <div className="card-body">
                            <div className="chart-area">
                                <canvas id="myAreaChart" key={selectedYear} />
                            </div>
                        </div>
                    </div>
                </div>
                <div className="col-xl-4 col-lg-4">
                    <div className="card shadow mb-4">
                        <div className="card-header py-3">
                            <h6 className="m-0 font-weight-bold text-primary">Daftar Pendapatan</h6>
                        </div>
                        <div className="card-body">
                            <div className="table-responsive">
                                <table className="table table-bordered" id="" width="100%" cellSpacing="0">
                                    <thead>
                                        <tr>
                                            <th>Bulan</th>
                                            <th>Pendapatan</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        {monthlyIncomeData.map(item => (
                                            <tr key={item.month}>
                                                <td>{item.month}</td>
                                                <td>{new Intl.NumberFormat('id-ID', { style: 'currency', currency: 'IDR' }).format(item.income)}</td>
                                            </tr>
                                        ))}
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default ChartComponent;
