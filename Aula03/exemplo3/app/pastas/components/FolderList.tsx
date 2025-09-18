import List from '@mui/material/List';
import { Folder } from './Folder';
import FolderItem from './FolderItem';

export default function FolderList(props: {folders: Folder[]}) {
  if(!props.folders.length){
    return(
      <div>
        <h1>Sem pastas</h1>
      </div>
    );
  }
  return (
    <List sx={{ width: '100%', maxWidth: 360}}>
      {props.folders.map(item => <FolderItem folder={item}/>)}
    </List>
  );
}