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

    console.log(idAlert);

    console.log("Before filter");
    console.log(dbAlertList);

    alert = dbAlertList.filter((alert) => alert.messageNumber === idAlert);

    console.log("After filter");
    console.log(alert);
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
    const result = await axios(`${baseUrl}${ao}/messages/1`);
    // console.log(result.data);
    return result.data.messageStats;
  };

  // useEffects
  http: useEffect(() => {
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

  return (
    <AppContext.Provider
      value={{
        date,
        dbAlertList,
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
