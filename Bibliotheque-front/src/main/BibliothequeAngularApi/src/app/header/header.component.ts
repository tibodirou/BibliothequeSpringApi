import { Component, Inject, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { DOCUMENT } from '@angular/common';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  constructor(private route: ActivatedRoute,private router : Router, @Inject(DOCUMENT) private document: Document) {}

  ngOnInit(): void {
  }

  
  public toHomePage(): void{
    this.router.navigate(['/'])
  }

  public share(): void{
    //this.document.location.href = 'https://twitter.com/';
    window.location.href='http://www.cnn.com/';
  }
}
