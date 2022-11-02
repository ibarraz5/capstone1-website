import React, { useContext, useEffect, useState } from "react";
import axios from "axios";

// any static variables go here
const monthHolder = [
  "January",
  "February",
  "March",
  "April",
  "May",
  "June",
  "July",
  "August",
  "September",
  "October",
  "November",
  "December",
];

const baseUrl = "http://localhost:8080/wea/";

// TODO: Remove this
const alerts = [
  {
    CMAC_message_number: "00001056",
    CMAC_sent_date_time: "2022-10-19 20:59:46",
    averageTime: "00:05:00",
    shortestTime: "00:05:00",
    longestTime: "00:05:00",
    averageDelay: "00:00:36",
    deviceCount: 2,
    receivedOutsideCount: 0,
    displayedOutsideCount: 1,
  },
  {
    CMAC_message_number: "00001057",
    CMAC_sent_date_time: "2022-11-19 21:59:46",
    averageTime: "00:05:00",
    shortestTime: "00:05:00",
    longestTime: "00:05:00",
    averageDelay: "00:00:36",
    deviceCount: 2,
    receivedOutsideCount: 0,
    displayedOutsideCount: 1,
  },
  {
    CMAC_message_number: "00001058",
    CMAC_sent_date_time: "2022-12-19 10:59:46",
    averageTime: "00:05:00",
    shortestTime: "00:05:00",
    longestTime: "00:05:00",
    averageDelay: "00:00:36",
    deviceCount: 2,
    receivedOutsideCount: 0,
    displayedOutsideCount: 1,
  },
];

const AppContext = React.createContext();

// Majority of logic takes place inside of the AppProvider function
const AppProvider = ({ children }) => {
  // State Variables

  const [date, setDate] = useState("");
  const [showModal, setShowModal] = useState(false);
  const [selectedAlert, setSelectedAlert] = useState(null);
  const [alertOriginator, setAlertOriginator] = useState("");
  const [login, setLogin] = useState(false);
  const [dbAlertList, setDbAlertList] = useState([]);
  const [messagesList, setMessagesList] = useState([]);

  // Functions
  const getDate = () => {
    let today = new Date();
    let day = String(today.getDate());
    let month = monthHolder[today.getMonth()];
    let year = today.getFullYear();
    setDate(`${month} ${day}, ${year}`);
  };

  /**
   * Filters the array of messages to locate the id of the selected
   * alert so that the modal can perform its operations.
   *
   * @param {int} idAlert
   */
  const selectAlert = (idAlert) => {
    let alert;

    console.log(messagesList);

    alert = messagesList.filter(
      (alert) => alert.CMAC_message_number !== idAlert
    );
    setSelectedAlert(alert);
    setShowModal(true);
  };

  const closeModal = () => {
    setShowModal(false);
  };

  /**
   * Fetches a list of cmac_message_numbers and their cmac_sent_date_times
   * that belong to a specified AO from the server. Call this function
   * when the user logs in to get their list of messages and use the list
   * to create the cards
   *
   * @param {string} ao The AO who's messages should be fetched.
   *                    '@' characters must be encoded as "%40"
   */
  const getMessageList = async (ao) => {
    const result = await axios(`${baseUrl}getMessageList?sender=${ao}`);
    return result.data;
  };

  /**
   * Fetches the stats for all the devices that received a given message.
   * Call this function when a card is opened to get the stats to display
   * on that card.
   *
   * @param {string} msgNum The cmac_message_number of the message to get
   *                        the stats for
   */
  const getMessageStats = async (msgNum) => {
    console.log(msgNum);
    console.log(Number(msgNum));

    const result = await axios(
      `${baseUrl}getMessageStats?messageNumber=${Number(msgNum)}`
    );
    return result.data;
  };

  // useEffects
  useEffect(() => {
    getDate();
  });

  useEffect(() => {
    if (!alertOriginator) {
      return;
    }

    const data = getMessageList(alertOriginator).then((data) =>
      setDbAlertList(data)
    );
  }, [alertOriginator]);

  useEffect(() => {
    if (dbAlertList.length <= 0) {
      return;
    }

    const messages = getMessageStats(dbAlertList[0].CMAC_message_number).then(
      (data) => setMessagesList(data)
    );
  }, [dbAlertList]);

  return (
    <AppContext.Provider
      value={{
        date,
        alerts,
        dbAlertList,
        messagesList,
        showModal,
        selectAlert,
        selectedAlert,
        closeModal,
        setAlertOriginator,
        alertOriginator,
        login,
        setLogin,
      }}
    >
      {children}
    </AppContext.Provider>
  );
};

export const useGlobalContext = () => {
  return useContext(AppContext);
};

export { AppContext, AppProvider };
