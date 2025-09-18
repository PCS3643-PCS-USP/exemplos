import type { Route } from "./+types/home";
import { Pastas } from "../pastas/pastas";

export function meta({}: Route.MetaArgs) {
  return [
    { title: "Exemplo 3" },
    { name: "description", content: "Exemplo 3 de PCS3643" },
  ];
}

export default function Home() {
  return <Pastas />;
}
