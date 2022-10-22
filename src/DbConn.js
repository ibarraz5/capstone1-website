const baseUrl = "http://localhost:8080/wea/";

/**
 * Fetches a list of cmac_message_numbers and their cmac_sent_date_times
 * that belong to a specified AO from the server. Call this function
 * when the user logs in to get their list of messages and use the list
 * to create the cards
 * 
 * @param {string} ao The AO who's messages should be fetched.
 *                    '@' characters must be encoded as "%40"
 */
export const getMessageList = async (ao) => {
    console.log(ao);
    const result = await fetch(`${baseUrl}getMessageList?sender=${ao}`);
    const data = await result.json();
    
    return data;
}

/**
 * Fetches the stats for all the devices that received a given message.
 * Call this function when a card is opened to get the stats to display
 * on that card.
 * 
 * @param {string} msgNum The cmac_message_number of the message to get
 *                        the stats for
 */
export const getMessageStats = async (msgNum) => {
    const result = await fetch(`${baseUrl}getMessageStats?messageNumber=${msgNum}`);
    const data = await result.json();
    
    return data;
}