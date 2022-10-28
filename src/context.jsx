import React, { useContext, useEffect, useState } from "react";

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

  // Functions
  const getDate = () => {
    let today = new Date();
    let day = String(today.getDate());
    let month = monthHolder[today.getMonth()];
    let year = today.getFullYear();
    setDate(`${month} ${day}, ${year}`);
  };

  const selectAlert = (idAlert) => {
    let alert;

    alert = alerts.find((alert) => alert.CMAC_message_number === idAlert);
    setSelectedAlert(alert);
    setShowModal(true);
  };

  const closeModal = () => {
    setShowModal(false);
  };

  // useEffects
  useEffect(() => {
    getDate();
  });

  useEffect(() => {
    if (!alertOriginator) {
      return;
    }
    setLogin(true);
  });

  return (
    <AppContext.Provider
      value={{
        date,
        alerts,
        showModal,
        selectAlert,
        selectedAlert,
        closeModal,
        setAlertOriginator,
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
