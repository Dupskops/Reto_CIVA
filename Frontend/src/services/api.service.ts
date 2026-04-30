import type {Bus, PageResponse} from '../types/bus.types';

const API_BASE_URL = 'http://localhost:8080/bus';

export const busService = {
    // Obtener la lista de buses
getBuses: async (page: number = 0, size: number = 10): Promise<PageResponse<Bus>> => {
        try {
            const response = await fetch(`${API_BASE_URL}?page=${page}&size=${size}`);
            if (!response.ok) throw new Error('Error al obtener los buses');
            return await response.json();
        } catch (error) {
            console.error(error);
            throw error;
        }
    },

    // Bus por ID
    getBusById: async (id: number): Promise<Bus> => {
        try {
            const response = await fetch(`${API_BASE_URL}/${id}`);
            if (!response.ok) throw new Error('Error al obtener el bus');
            return await response.json();
        } catch (error) {
            console.error(error);
            throw error;
        }
    }
};