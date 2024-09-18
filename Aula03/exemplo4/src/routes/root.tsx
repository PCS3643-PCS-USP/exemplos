import { Outlet, Link } from "react-router-dom";

export function Root() {
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
      <Outlet />
    </>
  );
}
