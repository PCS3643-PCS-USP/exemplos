import type { Route } from "./+types/home";
import { MyButton } from '../components/MyButton';


export function meta({}: Route.MetaArgs) {
  return [
    { title: "Exemplo 4" },
    { name: "description", content: "Contador" },
  ];
}

export default function Pagina1() {
  return (
    <div>
      <MyButton/>
      <MyButton/>
    </div>
  );
}