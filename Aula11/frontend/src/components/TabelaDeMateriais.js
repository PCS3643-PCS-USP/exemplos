import {useState, useEffect} from "react";
import { Button, TextField } from "@mui/material";
import { Grid, Box } from "@mui/material";
import { Dialog, DialogTitle, DialogContentText, DialogActions, DialogContent } from "@mui/material";
import { DataGrid } from '@mui/x-data-grid';

function TabelaDeMateriais() {
  let [materiais, setMateriais] = useState([]);
  let [nome, setNome] = useState([]);
  let [preco, setPreco] = useState([0]);
  let [open, setOpen] = useState(false);

  useEffect(() => {
    refresh();
  }, []);

  const refresh = () => {
    fetch('/api/materiais')
    .then(response => {
      return response.json();
    }).then(data => {
      setMateriais(data);
    }).catch((e) => {
      console.log(e.message);
    });
  };

  const handleClickOpen = () => {
    setOpen(true);
  };

  const handleClose = () => {
    setOpen(false);
  };

  const handleSubmit = async(e) => {
    try {
      let res = await fetch("/api/materiais", {
        headers: {
          'Content-Type': 'application/json'
        },
        method: "POST",
        dataType: "json",
        body: JSON.stringify({
          nome: nome,
          preco: preco,
        }),
      });
      await res.json();
      if (res.status === 200) {
        console.log("Ok");
        refresh();
        setOpen(false);
      } else {
        console.log("Erro");
      }
    } catch (err) {
      console.log(err);
    }
  };

  const colunas = [
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
      <Button id="cadastro" variant="outlined" onClick={handleClickOpen}>Cadastrar</Button>
      <Dialog open={open} onClose={handleClose}>
        <DialogTitle>Cadastrar</DialogTitle>
        <DialogContent>
          <DialogContentText>
            Dados do novo material
          </DialogContentText>
          <Box
            component="form"
            noValidate
            onSubmit={handleSubmit}
          >
              <Grid container spacing={2}>
                <Grid item xs={12}>
                  <TextField
                  required
                  autoFocus
                  margin="dense"
                  id="nome"
                  label="Nome"
                  type="text"
                  fullWidth
                  onChange={(e) => setNome(e.target.value)}
                  />
                </Grid>
                <Grid item xs={12}>
                  <TextField
                  required
                  autoFocus
                  margin="dense"
                  id="preco"
                  label="Preço"
                  type="number"
                  step={0.50}
                  fullWidth
                  onChange={(e) => setPreco(e.target.value)}
                  />
                </Grid>
              </Grid>
 
          </Box>
        </DialogContent>
        <DialogActions>
          <Button onClick={handleClose}>Cancelar</Button>
          <Button id="adicionar" onClick={handleSubmit}>Adicionar</Button>
        </DialogActions>
      </Dialog>
    </Box>
  );
};

export default TabelaDeMateriais;