export function handleAxiosError(error) {
    if (!error.response && error.code === "ERR_NETWORK") {
        return {
            code: 'ERR_CONNECTION_REFUSED',
            message: 'Сервер недоступен',
            time: Date.now()
        };
    } else {
        return error.response.data;
    }
}