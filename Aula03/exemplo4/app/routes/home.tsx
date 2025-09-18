import type { Route } from "./+types/home";

export function meta({}: Route.MetaArgs) {
  return [
    { title: "Exemplo 4" },
    { name: "description", content: "Home" },
  ];
}

export default function Home() {
  return <h1>Home</h1>;
}
