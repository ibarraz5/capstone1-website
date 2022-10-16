import { useGlobalContext } from "../context";

const Header = () => {
  const ao = "[Current Signed In Alert Originator]";
  const { date } = useGlobalContext();

  return (
    <header className="header-container">
      <h4 className="header-text">
        CMAC Alert Data <span className="alert-originator">{ao}</span>
      </h4>
      <p className="date">{date}</p>
    </header>
  );
};

export default Header;
