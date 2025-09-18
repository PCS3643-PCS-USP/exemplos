import { Link } from "react-router";

export function NavBar() {
  return (
    <>
      <nav>
        <ul>
            <li><Link to={'/'}>Home</Link></li>
        </ul>
        <ul>
            <li><Link to={'/p1'}>Página 1</Link></li>
         </ul>
         <ul>
            <li><Link to={'/p2'}>Página 2</Link></li>
        </ul>
      </nav>
    </>
  );
}
