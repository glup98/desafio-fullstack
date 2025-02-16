import "@/index.css";
import React from "react";
import ReactDOM from "react-dom/client";
import { ReactQueryProvider } from "./providers/QueryClienteProvider.tsx";
import App from "./App.tsx";

ReactDOM.createRoot(document.getElementById("root")!).render(
  <React.StrictMode>
    <ReactQueryProvider>
      <App />
    </ReactQueryProvider>
  </React.StrictMode>
);
