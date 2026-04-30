
import { useState, useEffect } from 'react';
import type { Bus } from '../types/bus.types';
import { busService } from '../services/api.service';
import './BusTable.css';
import civaLogo from '../assets/civa-logo.png'; 

export const BusTable = () => {
    // Manejo de estado con useState
    const [buses, setBuses] = useState<Bus[]>([]);
    const [page, setPage] = useState<number>(0);
    const [totalPages, setTotalPages] = useState<number>(0);
    const [loading, setLoading] = useState<boolean>(true);
    const [error, setError] = useState<string | null>(null);

    // Fetching de datos con la función fetch y useEffect
    useEffect(() => {
        const fetchBuses = async () => {
            try {
                setLoading(true);
                // Llama al api service
                const data = await busService.getBuses(page, 5); // 5 buses por pagina
                setBuses(data.content);
                setTotalPages(data.totalPages);
                setError(null);
            } catch (err) {
                setError('Hubo un error al cargar la información de los buses.');
            } finally {
                setLoading(false);
            }
        };

        fetchBuses();
    }, [page]); // Se ejecuta nuevamente si cambia la pagina

    // Funciones para la paginación
    const handleNextPage = () => {
        if (page < totalPages - 1) setPage(page + 1);
    };

    const handlePrevPage = () => {
        if (page > 0) setPage(page - 1);
    };

    if (loading && buses.length === 0) return <div style={{ textAlign: 'center', marginTop: '50px' }}>Cargando flota...</div>;
    if (error) return <div style={{ color: 'red', textAlign: 'center', marginTop: '50px' }}>{error}</div>;

    return (
        <div className="civa-container">
            <div className="civa-header">
                <img src={civaLogo} alt="CIVA Logo" className="civa-logo" onError={(e) => (e.currentTarget.style.display = 'none')} />
                <h2>Gestión de Flota</h2>
            </div>

            <div className="civa-table-wrapper">
                <table className="civa-table">
                    <thead>
                        <tr>
                            <th>N° Bus</th>
                            <th>Placa</th>
                            <th>Marca</th>
                            <th>Características</th>
                            <th>Fecha Registro</th>
                            <th>Estado</th>
                            <th>Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        {buses.map((bus) => (
                            <tr key={bus.id}>
                                <td><strong>{bus.numeroBus}</strong></td>
                                <td>{bus.placa}</td>
                                <td>{bus.marca}</td>
                                <td>{bus.caracteristicas}</td>
                                <td>{new Date(bus.fechaCreacion + 'Z').toLocaleDateString()}</td>
                                <td>
                                    <span className={bus.activo ? 'badge-active' : 'badge-inactive'}>
                                        {bus.activo ? 'Operativo' : 'En Mantenimiento'}
                                    </span>
                                </td>
                                <td>
                                    <button 
                                        style={{ backgroundColor: '#FF00D0', color: 'white', border: 'none', padding: '5px 10px', borderRadius: '4px', cursor: 'pointer' }}
                                        onClick={() => alert(`Detalles del Bus ID: ${bus.id}\nPlaca: ${bus.placa}\nMarca: ${bus.marca}\nCaracterísticas: ${bus.caracteristicas}`)}
                                    >
                                        Ver Detalles
                                    </button>
                                </td>
                            </tr>
                        ))}
                    </tbody>
                </table>
            </div>

            <div className="pagination">
                <button onClick={handlePrevPage} disabled={page === 0}>
                    &#8592; Anterior
                </button>
                <span>Página <strong>{page + 1}</strong> de <strong>{totalPages || 1}</strong></span>
                <button onClick={handleNextPage} disabled={page >= totalPages - 1}>
                    Siguiente &#8594;
                </button>
            </div>
        </div>
    );
};