import "./App.css";
import { useGlobalContext } from "./context";
import Header from "./components/Header";
import Footer from "./components/Footer";
import Alerts from "./components/Alerts";
import Modal from "./components/Modal";
import Body from "./components/Body";
import Login from "./components/Login";

// I placed test text and context placeholder text for
// everyone to hopefully understand how the context works.
// It will show up in the test text main, and also the developer console.

function App() {
  const { showModal } = useGlobalContext();

  return (
    <main>
      <div className="page-content">
        <div className="content-wrap">
          <Header></Header>
          <Alerts></Alerts>
          {showModal && <Modal></Modal>}
          <Body></Body>
        </div>
        <Footer></Footer>
      </div>
    </main>
  );
}

export default App;
