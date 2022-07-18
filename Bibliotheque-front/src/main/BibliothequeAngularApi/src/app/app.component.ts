import { Component, OnInit } from '@angular/core';
import { Livre } from './livre';



@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'BibliothequeAngularApi';


  public livres : Livre[];
  
  constructor(){}

  ngOnInit(): void {
    
  }

  public showTable(){
    
  }
  

}


