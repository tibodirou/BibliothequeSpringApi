import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Livre } from '../livre';
import { LivreService } from '../services/livre-service';
import { NotificationService } from '../services/notification-service';

@Component({
  selector: 'app-livre-modifier',
  templateUrl: './livre-modifier.component.html',
  styleUrls: ['./livre-modifier.component.css']
})
export class LivreModifierComponent implements OnInit {

  constructor(private route: ActivatedRoute,private router :Router,private livreService : LivreService, private notificationService : NotificationService){}
  public id : number;
  public livre = new Livre()
  ngOnInit(): void {
    const routeParams = this.route.snapshot.paramMap.get('id') as string;
    this.id = parseInt(routeParams);
    this.getDetails();
  }


  public modifyLivre() : void{
    console.log(this.livre)
    this.livreService.updateLivre(this.livre).subscribe({
      next :()=>{
      this.notificationService.openSnackBar("Livre Modifié", "OK")},
      error: (error : HttpErrorResponse) => {
        //alert("error.message");
      }
    }
    )
  }


  public getDetails(): void{
    this.livreService.getLivreDetails(this.id).subscribe({
      next: (response : Livre) => {
        this.livre = response;        
      },

    }
    )
  }

}
