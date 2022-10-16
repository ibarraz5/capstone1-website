import "./App.css";
import { useGlobalContext } from "./context";
<<<<<<< HEAD
import Header from "./components/Header";
=======
import { Database } from "./components/Database";
>>>>>>> 13d4d4e6d808f6591bafb2b3230dae16fdf486e2

// I placed test text and context placeholder text for
// everyone to hopefully understand how the context works.
// It will show up in the test text main, and also the developer console.

function App() {
  const context = useGlobalContext();
  console.log(context);
<<<<<<< HEAD
  return (
    <main>
      <Header></Header>
    </main>
  );
=======
  return <main>This is test text! {context.ThisIs}<Database /></main>;
>>>>>>> 13d4d4e6d808f6591bafb2b3230dae16fdf486e2
}

export default App;
