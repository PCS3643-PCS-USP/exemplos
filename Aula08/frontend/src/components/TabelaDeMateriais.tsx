import {useState, useEffect} from "react";
import Box from '@mui/material/Box';
import { DataGrid, GridColDef } from '@mui/x-data-grid';
import { Material } from "./Material";

export default function TabelaDeMateriais() {
  let [materiais, setMateriais] = useState<Material[]>();

  useEffect(() => {
    // fetch('/pcs-gme/api/materiais')
    fetch('http://localhost:8080/pcs-gme/api/materiais')
    .then(response => {
      return response.json();
    }).then(data => {
      setMateriais(data);
    }).catch((e) => {
      console.log(e.message);
    });
  }, []);

  const colunas: GridColDef<(Material[])[number]>[] = [
    {field: 'codigo', headerName: 'Código'},
    {field: 'nome', headerName: 'Nome'},
    {field: 'preco', headerName: 'Preço'}
  ];

  return (
    <Box sx={{ height: 400, width: '100%' }}>
        <DataGrid
         getRowId={(row) => row.codigo}
         rows={materiais}
         columns={colunas}
       />
    </Box>
  );
};

