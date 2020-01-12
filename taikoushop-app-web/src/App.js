import React, {useState} from 'react';
import './App.css';
import NavBar from "./components/NavBar";
import axi from 'axios';




function App() {
    let data;

    const [count, setCount] = useState(0);

    axi.get('http://localhost:8083/api/getUser')
        .then(function (response) {
            // handle success
            setCount(response.data.user);
        });

  return (
    <div className="App">
      <NavBar/>

        {count}
    </div>
  );
}

export default App;
