import { createBrowserRouter } from "react-router-dom";
import { RouterProvider } from "react-router-dom";
import { Root } from "./routes/root";
import { Home } from "./routes/home";
import { Pagina1 } from "./routes/pagina1";
import { Pagina2 } from "./routes/pagina2";
import { ErrorPage } from "./routes/errorpage";


const router = createBrowserRouter([
  {
    path: "/",
    element: <Root />,
    errorElement: <ErrorPage/>,
    children: [{
      index: true, 
      element: <Home/>
    }, {
      path: "/p1",
      element: <Pagina1/>
    }, {
      path: "/p2",
      element: <Pagina2/>
    }],
  },
], {
  basename: "/pcs-gme",
});

function App() {
  return (
    <RouterProvider router={router}/>
  );
}

export default App;