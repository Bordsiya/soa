// Запуск: npm install axios; node haproxy_resolve.js =)
// Далее содержимое файла haproxy.cfg можно использовать при перезапуске haproxy

const axios = require('axios');
const fs = require('fs').promises;

async function updateHaproxyConfig(formattedStrings) {
    try {
        let haproxyConfig = await fs.readFile('./haproxy.cfg', 'utf-8');

        // Удалим все строки, начиная с 47-й(обновление строк для конфигурирования first-services)
        haproxyConfig = haproxyConfig.split('\n').slice(0, 46).join('\n');
        haproxyConfig += '\n' + formattedStrings.join('\n') + '\n';

        await fs.writeFile('./haproxy.cfg', haproxyConfig, 'utf-8');
        console.log('haproxy.cfg успешно обновлен.');
    } catch (error) {
        console.error('Ошибка при обновлении haproxy.cfg:', error.message);
    }
}

async function getConsulServices() {
    try {
        const response = await axios.get('http://localhost:8500/v1/agent/services');
        const services = response.data;

        // Фильтруем сервисы с тегом "SOA"
        const soaServices = Object.values(services)
            .filter(service => service.Service === 'soa');

        console.log(soaServices)

        // Создаем строку для каждого сервиса
        const formattedStrings = soaServices.map(service => {
            const address = service.Address; // FQDN
            return `\tfirst-service-${address} ${service.ID.replace('-', '')}:${service.Port} check ssl ca-file /etc/ssl/certs/orgdirectory.pem`;
        });

        // Обновляем файл haproxy.cfg
        await updateHaproxyConfig(formattedStrings);
    } catch (error) {
        console.error('Ошибка при получении Consul-сервисов:', error.message);
    }
}

// Вызов функции для получения и обновления данных
getConsulServices();
