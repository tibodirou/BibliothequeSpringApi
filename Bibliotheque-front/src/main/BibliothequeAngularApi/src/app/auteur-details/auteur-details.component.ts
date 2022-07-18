import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { ActivatedRoute, Router } from '@angular/router';
import { Livre } from '../livre';
import { LivreService } from '../services/livre-service';

@Component({
  selector: 'app-auteur-details',
  templateUrl: './auteur-details.component.html',
  styleUrls: ['./auteur-details.component.css']
})
export class AuteurDetailsComponent implements OnInit {
  @ViewChild(MatPaginator) paginator! : MatPaginator;
  @ViewChild(MatSort) matSort! : MatSort;
  dataSource: MatTableDataSource<Livre>;
  columnsToDisplay = ['titre', 'auteur', "illustrateur", "editeur", "collection"];
  constructor(private route: ActivatedRoute, private router: Router, private livreService: LivreService,) { }
  public name: string;
  public livres: Livre[];
  selectedRow;
  ngOnInit(): void {
    const routeParams = this.route.snapshot.paramMap.get('id') as string;
    this.name = routeParams;
    this.getDetails();
  }

  public getDetails(): void {
    this.livreService.getAuteurLivres(this.name.replace(" ", "%20")).subscribe({
      next: (response: Livre[]) => {
        this.livres = response
        this.dataSource = new MatTableDataSource(response)
        this.dataSource.paginator = this.paginator;
        this.dataSource.sort = this.matSort;

      },
      error: (error: HttpErrorResponse) => {
        //alert(error.message);
      }
    })
  }

  onSelectedRow(livre: Livre) {
    this.selectedRow = livre;
    this.router.navigate(['/details', livre.id]);
  }

}
