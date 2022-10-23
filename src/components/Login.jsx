import { useState } from "react";
import { useGlobalContext } from "../context";

const Login = () => {
  const [user, setUser] = useState("");
  const { setAlertOriginator, setLogin } = useGlobalContext();

  const handleChange = (e) => {
    setUser(e.target.value);
  };

  const handleSubmit = (e) => {
    e.preventDefault();

    if (user) {
      setAlertOriginator(user);
      setLogin(true);
    }
  };

  return (
    <form onSubmit={handleSubmit}>
      <input
        className="form-input"
        type="text"
        placeholder="Alert Originator"
        onChange={handleChange}
        value={user}
      ></input>

      <button className="btn" type="submit">
        Login
      </button>
    </form>
  );
};

export default Login;
