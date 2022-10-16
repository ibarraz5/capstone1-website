var baseUrl = "http://localhost:8080/wea/";

const Database = {
    /**
     * Fetches a list of cmac_message_numbers and their cmac_sent_date_times
     * that belong to a specified AO from the server
     * 
     * @param {string} ao The AO who's messages should be fetched
     */
    async getMessageList(ao) {
        const result = await fetch(`${baseUrl}getMessageList?sender=${ao}`);
        const data = await result.json();
    }
}

module.exports = Database;