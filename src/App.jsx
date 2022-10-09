import "./App.css";
import { useGlobalContext } from "./context";
import Favorites from "./components/Favorites";
import Meals from "./components/Meals";
import Modal from "./components/Modal";
import Search from "./components/Search";
import Tables from "./components/Tables";

function App() {
  const { showModal, favorites } = useGlobalContext();
  return (
    <main>
      <Search></Search>
      {favorites.length > 0 && <Favorites></Favorites>}
      <Meals></Meals>
      {showModal && <Modal></Modal>}
      <Tables></Tables>
    </main>
  );
}

export default App;
