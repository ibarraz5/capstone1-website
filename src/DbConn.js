const baseUrl = "http://localhost:8080/wea/";

/**
 * Fetches a list of cmac_message_numbers and their cmac_sent_date_times
 * that belong to a specified AO from the server. Use the results to
 * create a list of message cards for the user to select.
 * 
 * @param {string} ao The AO who's messages should be fetched
 */
export const getMessageList = async (ao) => {
    console.log(ao);
    const result = await fetch(`${baseUrl}getMessageList?sender=${ao}`);
    const data = await result.json();
    
    return data;
}

/**
 * Fetches the stats for all the devices that received a given message.
 * Call this message when a card is opened to get the stats for that
 * card.
 * 
 * @param {string} msgNum The cmac_message_number of the message to get
 *                        the stats for
 */
export const getMessageStats = async (msgNum) => {
    const result = await fetch(`${baseUrl}getMessageStats?messageNumber=${msgNum}`);
    const data = await result.json();
    
    return data;
}