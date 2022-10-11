import "./App.css";
import { useGlobalContext } from "./context";

// I placed test text and context placeholder text for
// everyone to hopefully understand how the context works.
// It will show up in the test text main, and also the developer console.

function App() {
  const context = useGlobalContext();
  console.log(context);
  return <main>This is test text! {context.ThisIs}</main>;
}

export default App;
