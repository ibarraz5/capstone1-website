import { useGlobalContext } from "../context";

const Modal = () => {
  const { selectedAlert, closeModal } = useGlobalContext();

  const {
    CMAC_sent_date_time: dateTime,
    CMAC_message_number: id,
    averageTime,
    shortestTime,
    longestTime,
    averageDelay,
    deviceCount,
    receivedOutsideCount,
    displayedOutsideCount,
  } = selectedAlert;

  return (
    <aside className="modal-overlay">
      <div className="modal-container">
        <header>
          <h4>CMAC Alert {dateTime}</h4>
          <h4>{id}</h4>
          <button
            className="btn btn-hipster close-btn top-btn"
            onClick={closeModal}
          >
            Close
          </button>
        </header>
        <svg
          xmlns="http://www.w3.org/2000/svg"
          width="300"
          height="150"
          viewBox="0 0 300 150"
          className="img modal-img"
        >
          <rect fill="#ddd" width="300" height="150" />
          <text
            fill="rgba(0,0,0,0.5)"
            font-family="sans-serif"
            font-size="30"
            dy="10.5"
            font-weight="bold"
            x="50%"
            y="50%"
            text-anchor="middle"
          >
            300×150
          </text>
        </svg>
        <div className="modal-content">
          <p>CMAC Average Time: {averageTime}</p>
          <p>CMAC Lowest Response Time: {shortestTime}</p>
          <p>CMAC Highest Reponse Time: {longestTime}</p>
          <p>CMAC Average Time Delay: {averageDelay}</p>
          <p>Device Count: {deviceCount}</p>
          <p>Devices outside of Alert Geo: {receivedOutsideCount}</p>
          <p>Total devices reached: {displayedOutsideCount}</p>
          <button className="btn btn-hipster close-btn" onClick={closeModal}>
            Close
          </button>
        </div>
      </div>
    </aside>
  );
};

export default Modal;