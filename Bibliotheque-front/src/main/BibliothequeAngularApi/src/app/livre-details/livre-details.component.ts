import { Component, OnInit } from '@angular/core';
import { LivreService } from '../services/livre-service';
import { Livre } from '../livre';
import { HttpErrorResponse } from '@angular/common/http';
import { ActivatedRoute, Router } from '@angular/router';
import { NotificationService } from '../services/notification-service';

@Component({
  selector: 'app-livre-details',
  templateUrl: './livre-details.component.html',
  styleUrls: ['./livre-details.component.css']
})
export class LivreDetailsComponent implements OnInit {


  constructor(private route: ActivatedRoute,private router :Router, private livreService : LivreService, private notificationService :NotificationService) { }
  public loaded: boolean;
  public id : number;
  public livre : Livre;
  ngOnInit(): void {
    const routeParams = this.route.snapshot.paramMap.get('id') as string;
    this.id = parseInt(routeParams);
    this.getDetails();
  }

  public deleteLivre(): void{
    this.livreService.deleteLivre(this.id).subscribe({
      next: (response : String) => { 
        this.notificationService.openSnackBar("Le livre à été suprimé","OK")
        this.router.navigate(['/Bibliotheque']);
      },
      error: (error : HttpErrorResponse) => {
        //alert(error.message)
      }
      }
    )
  }
  public modifyLivre() : void{
    this.router.navigate(['/Modify', this.livre.id]);
  }
  public getAuteurDetails(): void{
    console.log(this.livre.auteur)
    this.router.navigate(['/auteur', this.livre.auteur]);
  }

  public getDetails(): void{
    this.livreService.getLivreDetails(this.id).subscribe({
      next: (response : Livre) => {
        this.livre = response;        
      },
      error: (error : HttpErrorResponse) => {
        //alert(error.message);
        var lvr: Livre = {
          id : 0,
          titre : "titre test",
          auteur : "auteur test",
          illustrateur : "illustrateur test",
          editeur : "editeur test",
          collection : [["collection A"],["collection B"]]

      }
      this.livre = lvr
      }
    }
    )
    this.loaded = true
  }
}
