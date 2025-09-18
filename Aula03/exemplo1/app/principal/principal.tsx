import { useState } from 'react';
import '../app.css';

export function Principal() {
  let [clicks, setClicks] = useState<number>(0);
  function count() {
    setClicks(clicks + 1);
  }
  
  return (
    <div className='principal'>
    <button onClick={count}>Contar</button><br />
    Clicados {clicks} vezes.
    </div>
  );
}