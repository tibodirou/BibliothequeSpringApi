import { Component, OnInit } from '@angular/core';
import { Livre } from '../livre';
import { LivreService } from '../services/livre-service';
import { HttpErrorResponse } from '@angular/common/http';
import { NotificationService } from '../services/notification-service';

@Component({
  selector: 'app-livre-form',
  templateUrl: './livre-form.component.html',
  styleUrls: ['./livre-form.component.css']
})
export class LivreFormComponent implements OnInit {

    

  constructor(private livreService : LivreService, private notificationService : NotificationService){}
  public livre = new Livre()
  ngOnInit(): void {
  }

  public postLivre(): void{
    console.log(this.livre)
    this.livreService.addLivres(this.livre).subscribe({
      next :()=>{
      this.notificationService.openSnackBar("Livre Ajouté", "OK")},
      error: (error : HttpErrorResponse) => {
        //alert("error.message");
      }
    }
    )
  }
  

}
