import { useGlobalContext } from "../context";

const Alerts = () => {
  const { alerts } = useGlobalContext();
  return (
    <section className="section-center">
      {alerts.map((alert) => {
        const { CMAC_message_number: id, CMAC_sent_date_time: dateTime } =
          alert;

        return (
          <article key={id} className="single-alert">
            <svg
              xmlns="http://www.w3.org/2000/svg"
              width="300"
              height="150"
              viewBox="0 0 300 150"
              className="img"
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
            <footer>
              <h5>{dateTime}</h5>
              <h5>{id}</h5>
            </footer>
          </article>
        );
      })}
    </section>
  );
};

export default Alerts;
