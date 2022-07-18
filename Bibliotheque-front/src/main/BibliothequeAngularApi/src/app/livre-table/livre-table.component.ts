import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { Livre } from '../livre';
import { LivreService } from '../services/livre-service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-livre-table',
  templateUrl: './livre-table.component.html',
  styleUrls: ['./livre-table.component.css']
})
export class LivreTableComponent implements OnInit {

  @ViewChild(MatPaginator) paginator! : MatPaginator;
  @ViewChild(MatSort) matSort! : MatSort;

  columnsToDisplay = ['titre', 'auteur', "illustrateur", "editeur", "collection"];
  dataSource: MatTableDataSource<Livre>;
  public livres : Livre[];
  selectedRow;

  constructor(private livreService : LivreService, private router :Router){}

  ngOnInit(): void {
    this.getLivres();
    
    
  }

  public getLivres(): void{
    this.livreService.getLivres().subscribe({
      next: (response : Livre[]) => {
        this.livres = response;
        this.dataSource = new MatTableDataSource(response)
        this.dataSource.paginator = this.paginator;
        this.dataSource.sort = this.matSort;
        
      },
      error: (error : HttpErrorResponse) => {
        //alert(error.message);
        this.livres = this.GenerateLivres();
        this.dataSource = new MatTableDataSource(this.livres)
        this.dataSource.paginator = this.paginator;
        this.dataSource.sort = this.matSort;
      }
    }
    )
  }

  public getAuteurDetails(livre : Livre): void{
    this.router.navigate(['/auteur', livre.auteur]);
  }
    public GenerateLivres(): Livre[]{
      var MockLivre: Livre[] = [];
      for (let i = 0; i < 20; i++){
          var lvr: Livre = {
              id : i,
              titre : "titre" + i,
              auteur : "auteur" + i,
              illustrateur : "illustrateur" + i,
              editeur : "editeur" + i,
              collection : [["collection A"],["collection B"]]

          }
          MockLivre.push(lvr)
      }
      return MockLivre;
  }
  
  public filterData($event : any){
    this.dataSource.filter = $event.target.value;
  }

  onSelectedRow(livre : Livre){
      this.selectedRow = livre;
      this.router.navigate(['/details', livre.id]);
  }

}

