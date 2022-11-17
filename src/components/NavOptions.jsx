import { useGlobalContext } from "../context";

const NavOptions = () => {
  const { increasePage, decreasePage, page } = useGlobalContext();

  return (
    <section className="nav-options">
      <div className="nav">
        <button className="nav-btn btn btn-hipster" onClick={decreasePage}>
          &lt;&lt; Prev
        </button>
        <div className="curr-page-container">
          <p className="curr-page">Current Page: {page}</p>
        </div>
        <button className="nav-btn btn btn-hipster" onClick={increasePage}>
          Next &gt;&gt;
        </button>
      </div>
    </section>
  );
};

export default NavOptions;
