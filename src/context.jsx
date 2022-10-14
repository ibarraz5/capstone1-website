import React, { useContext, useEffect, useState } from "react";

// any static variables go here

const AppContext = React.createContext();

// Majority of logic takes place inside of the AppProvider function
const AppProvider = ({ children }) => {
  // State Variables

  // Functions

  // useEffects

  return (
    <AppContext.Provider value={{ ThisIs: "Placeholder" }}>
      {children}
    </AppContext.Provider>
  );
};

export const useGlobalContext = () => {
  return useContext(AppContext);
};

export { AppContext, AppProvider };
