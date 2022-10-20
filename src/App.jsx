import "./App.css";
import { useGlobalContext } from "./context";
import Header from "./components/Header";
import Footer from "./components/Footer";

// I placed test text and context placeholder text for
// everyone to hopefully understand how the context works.
// It will show up in the test text main, and also the developer console.

function App() {
  const context = useGlobalContext();
  console.log(context);
  return (
    <main>
      <Header></Header>
      <Footer></Footer>
    </main>
  );
}

export default App;
