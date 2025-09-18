import { type RouteConfig, index, route } from "@react-router/dev/routes";

export default [
    index("routes/home.tsx"),
    route("p1", "./routes/pagina1.tsx"),
    route("p2", "./routes/pagina2.tsx")
] satisfies RouteConfig;
