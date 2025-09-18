import type { Route } from "./+types/home";
import { Principal } from "../principal/principal";

export function meta({}: Route.MetaArgs) {
  return [
    { title: "Exemplo 2" },
    { name: "description", content: "Exemplo 2 de PCS3643" },
  ];
}

export default function Home() {
  return <Principal />;
}
