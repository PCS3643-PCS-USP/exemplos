import { useState } from 'react';

export function MyButton() {
  let [clicks, setClicks] = useState<number>(0);
  function count() {
    setClicks(clicks + 1);
  }

  return (
    <div className='principal'>
      <button onClick={count}>Contar</button><br />
      Clicado {clicks} vezes.
    </div>
  );
}
