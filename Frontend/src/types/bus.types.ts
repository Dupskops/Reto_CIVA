// Interfaz que muestra el BusResponseDTO
export interface Bus {
    id: number;
    numeroBus: string;
    placa: string;
    fechaCreacion: string;
    caracteristicas: string;
    marca: string;
    activo: boolean;
}

// Interfaz para paginación
export interface PageResponse<T> {
    content: T[];
    pageable: {
        pageNumber: number;
        pageSize: number;
    };
    totalElements: number;
    totalPages: number;
    last: boolean;
}