import { HttpErrorResponse } from '@angular/common/http';
import { ErrorHandler, Injectable } from '@angular/core';
import { NotificationService } from '../services/notification-service';

@Injectable()
export class GlobalErrorHandler implements ErrorHandler {

  constructor(private notificationService : NotificationService){}
  
  handleError(error: any) {
    // Custom error handling logic    
    if (error instanceof HttpErrorResponse){
      this.notificationService.openSnackBar("Server side error", "OK")
    }
    else{
      console.log(error.message)
      this.notificationService.openSnackBar("Client side error", "OK")
    }
    //differentes categories, differentes solutions
    
  }
  
}