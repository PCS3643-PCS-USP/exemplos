import type { Route } from "./+types/home";
import { Pastas } from "../pastas/pastas";

export function meta({}: Route.MetaArgs) {
  return [
    { title: "Exemplo 4" },
    { name: "description", content: "Pastas" },
  ];
}

export default function Pagina2() {
  return <Pastas />;
}
