import './App.css';
import FolderList from './components/FolderList';
import {Folder} from './components/Folder';

export default function App() {
  const items:Folder[] = [
    new Folder('Arquivos', '23 Mb'),
    new Folder('Fotos', '10Gb')
  ];
  return (
    <div>
      <FolderList folders={items}/>
    </div>
  );
}