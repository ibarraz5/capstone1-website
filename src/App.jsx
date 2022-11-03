import "./App.css";
import { useGlobalContext } from "./context";
import Header from "./components/Header";
import Footer from "./components/Footer";
import Alerts from "./components/Alerts";
import Modal from "./components/Modal";
// import Body from "./components/Body";
import Login from "./components/Login";

// I placed test text and context placeholder text for
// everyone to hopefully understand how the context works.
// It will show up in the test text main, and also the developer console.

function App() {
  const { showModal, login } = useGlobalContext();

  return (
    <main>
      <div className="page-content">
        <div className="content-wrap">
          {!login && <Login></Login>}
          {login && <Header></Header>}
          {login && <Alerts></Alerts>}
          {showModal && <Modal></Modal>}
          {/* {login && <Body></Body>} */}
        </div>
        {login && <Footer></Footer>}
      </div>
    </main>
  );
}

export default App;
